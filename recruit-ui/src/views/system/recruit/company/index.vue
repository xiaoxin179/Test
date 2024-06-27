<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="公司名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="企业性质" prop="nature">
        <el-select v-model="queryParams.nature" placeholder="请选择企业性质" clearable size="small">
          <el-option
            v-for="dict in natureOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审核状态" prop="auditState">
        <el-select v-model="queryParams.auditState" placeholder="请选择审核状态" clearable size="small">
          <el-option
            v-for="dict in auditStateOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="是否热门" prop="hot">-->
<!--        <el-select v-model="queryParams.hot" placeholder="请选择是否热门" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in hotOptions"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="所属用户" prop="userId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userId"-->
<!--          placeholder="请输入所属用户"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['recruit:info:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['recruit:info:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['recruit:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruit:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="公司名称" align="center" prop="name">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <el-form label-suffix=":">
              <el-form-item label="公司LOGO">
                <el-image
                  style="width: 100px; height: 100px"
                  :src="scope.row.logo"
                  :preview-src-list="[scope.row.logo]">
                </el-image>
              </el-form-item>
              <el-form-item label="营业执照">
                <el-image
                  style="width: 100px; height: 100px"
                  :src="scope.row.license"
                  :preview-src-list="[scope.row.license]">
                </el-image>
              </el-form-item>
              <el-form-item label="企业描述" style="width: 250px;">
                {{ scope.row.description }}
              </el-form-item>
            </el-form>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="公司地址" align="center" prop="address" />
      <el-table-column label="联系电话" align="center" prop="phonenumber" />
<!--      <el-table-column label="公司LOGO" align="center" prop="logo" />-->
<!--      <el-table-column label="营业执照" align="center" prop="license" />-->
      <el-table-column label="企业性质" align="center" prop="nature" :formatter="natureFormat" />
<!--      <el-table-column label="企业描述" align="center" prop="description" />-->
      <el-table-column label="审核状态" align="center" prop="auditState" :formatter="auditStateFormat" />
      <el-table-column label="是否热门" align="center" prop="hot" :formatter="hotFormat" />
      <el-table-column label="所属用户" align="center" prop="userId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row,2)"
            v-hasPermi="['recruit:info:agree']"
          >通过</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row,3)"
            v-hasPermi="['recruit:info:reject']"
          >驳回</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruit:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改企业信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="公司名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="公司地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入公司地址" />
        </el-form-item>
        <el-form-item label="联系电话" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="公司LOGO" prop="logo">
          <el-input v-model="form.logo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="营业执照" prop="license">
          <el-input v-model="form.license" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="企业性质" prop="nature">
          <el-select v-model="form.nature" placeholder="请选择企业性质">
            <el-option
              v-for="dict in natureOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="企业描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入企业描述" />
        </el-form-item>
        <el-form-item label="审核状态" prop="auditState">
          <el-select v-model="form.auditState" placeholder="请选择审核状态">
            <el-option
              v-for="dict in auditStateOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否热门" prop="hot">
          <el-select v-model="form.hot" placeholder="请选择是否热门">
            <el-option
              v-for="dict in hotOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入所属用户" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addInfo, delInfo, exportInfo, listInfo, updateInfo } from '@/api/recruit/company/info'
import { mapGetters } from 'vuex'

export default {
  name: "Info",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 企业信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 企业性质字典
      natureOptions: [],
      // 审核状态字典
      auditStateOptions: [],
      // 是否热门字典
      hotOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        address: null,
        phonenumber: null,
        logo: null,
        license: null,
        nature: null,
        description: null,
        auditState: null,
        hot: null,
        userId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "公司名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "公司地址不能为空", trigger: "blur" }
        ],
        phonenumber: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ],
        nature: [
          { required: true, message: "企业性质不能为空", trigger: "change" }
        ],
        auditState: [
          { required: true, message: "审核状态不能为空", trigger: "change" }
        ],
        hot: [
          { required: true, message: "是否热门不能为空", trigger: "change" }
        ],
        userId: [
          { required: true, message: "所属用户不能为空", trigger: "blur" }
        ]
      }
    };
  },
  computed: {
    ...mapGetters([
      'userId',
      'isCompany',
    ]),
  },
  created() {
    this.getList();
    this.getDicts("company_nature").then(response => {
      this.natureOptions = response.data;
    });
    this.getDicts("company_status").then(response => {
      this.auditStateOptions = response.data;
    });
    this.getDicts("recruit_hot").then(response => {
      this.hotOptions = response.data;
    });
  },
  methods: {
    /** 查询企业信息列表 */
    getList() {
      this.loading = true;
      //如果是企业，只查询自己的
      if (this.isCompany) {
        this.queryParams.userId=this.userId
      }
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 企业性质字典翻译
    natureFormat(row, column) {
      return this.selectDictLabel(this.natureOptions, row.nature);
    },
    // 审核状态字典翻译
    auditStateFormat(row, column) {
      return this.selectDictLabel(this.auditStateOptions, row.auditState);
    },
    // 是否热门字典翻译
    hotFormat(row, column) {
      return this.selectDictLabel(this.hotOptions, row.hot);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        address: null,
        phonenumber: null,
        logo: null,
        license: null,
        nature: null,
        description: null,
        auditState: null,
        hot: null,
        userId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    // handleAdd() {
    //   this.reset();
    //   this.open = true;
    //   this.title = "添加企业信息";
    // },
    /** 修改按钮操作 */
    handleUpdate(row,auditState) {
      this.reset();
      this.form.id=row.id || this.ids
      this.form.userId=row.userId
      this.form.auditState=auditState
      updateInfo(this.form).then(response => {
        this.msgSuccess("修改成功");
        this.getList();
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除企业信息编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有企业信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportInfo(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
