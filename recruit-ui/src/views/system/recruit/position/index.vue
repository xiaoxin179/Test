<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="岗位名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入岗位名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作城市" prop="workCity">
        <el-input
          v-model="queryParams.workCity"
          placeholder="请输入工作城市"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="phonenumber">
        <el-input
          v-model="queryParams.phonenumber"
          placeholder="请输入联系电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布时间" prop="releaseDate">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.releaseDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择发布时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="截止日期" prop="validDate">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.validDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择截止日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="招聘人数" prop="quantity">
        <el-input
          v-model="queryParams.quantity"
          placeholder="请输入招聘人数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="状态" prop="status">-->
<!--        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in statusOptions"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
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
      <el-form-item label="最低薪资" prop="salaryDown">
        <el-input
          v-model="queryParams.salaryDown"
          placeholder="请输入最低薪资"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高薪资" prop="salaryUp">
        <el-input
          v-model="queryParams.salaryUp"
          placeholder="请输入最高薪资"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="公司ID" prop="companyId">-->
<!--        <el-input-->
<!--          v-model="queryParams.companyId"-->
<!--          placeholder="请输入公司ID"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
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
<!--      <el-form-item label="分类ID" prop="categoryId">-->
<!--        <el-input-->
<!--          v-model="queryParams.categoryId"-->
<!--          placeholder="请输入分类ID"-->
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['recruit:position:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['recruit:position:edit']"
        >{{isCompany?'修改':'审核'}}</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['recruit:position:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruit:position:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="positionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="岗位名称" align="center" prop="name" />
      <el-table-column label="要求" align="center" prop="requirement" />
      <el-table-column label="工作城市" align="center" prop="workCity" />
      <el-table-column label="联系电话" align="center" prop="phonenumber" />
      <el-table-column label="发布时间" align="center" prop="releaseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.releaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="截止日期" align="center" prop="validDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.validDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="招聘人数" align="center" prop="quantity" />
<!--      <el-table-column label="状态" align="center" prop="status" :formatter="statusFormat" />-->
      <el-table-column label="审核状态" align="center" prop="auditState" :formatter="auditStateFormat" />
      <el-table-column label="最低薪资" align="center" prop="salaryDown" />
      <el-table-column label="最高薪资" align="center" prop="salaryUp" />
      <el-table-column label="公司ID" align="center" prop="companyId" />
<!--      <el-table-column label="是否热门" align="center" prop="hot" :formatter="hotFormat" />-->
<!--      <el-table-column label="分类ID" align="center" prop="categoryId" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['recruit:position:edit']"
          >{{isCompany?'修改':'审核'}}</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruit:position:remove']"
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

    <!-- 添加或修改招聘岗位对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="岗位名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入岗位名称" />
        </el-form-item>
        <el-form-item label="要求" prop="requirement">
          <el-input v-model="form.requirement" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作城市" prop="workCity">
          <el-input v-model="form.workCity" placeholder="请输入工作城市" />
        </el-form-item>
        <el-form-item label="联系电话" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="发布时间" prop="releaseDate">
          <el-date-picker clearable size="small" style="width: 200px"
                          v-model="form.releaseDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择发布时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="截止日期" prop="validDate">
          <el-date-picker clearable size="small" style="width: 200px"
                          v-model="form.validDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择截止日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="招聘人数" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入招聘人数" />
        </el-form-item>
<!--        <el-form-item label="状态" prop="status">-->
<!--          <el-select v-model="form.status" placeholder="请选择状态">-->
<!--            <el-option-->
<!--              v-for="dict in statusOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictLabel"-->
<!--              :value="parseInt(dict.dictValue)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item v-if="form.id&&!isCompany" label="审核状态" prop="auditState">
          <el-select v-model="form.auditState" placeholder="请选择审核状态">
            <el-option
              v-for="dict in auditStateOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="最低薪资" prop="salaryUp">
          <el-input v-model="form.salaryDown" placeholder="请输入最低薪资" />
        </el-form-item>
        <el-form-item label="最高薪资" prop="salaryDown">
          <el-input v-model="form.salaryUp" placeholder="请输入最高薪资" />
        </el-form-item>
<!--        <el-form-item label="公司ID" prop="companyId">-->
<!--          <el-input v-model="form.companyId" placeholder="请输入公司ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="是否热门" prop="hot">-->
<!--          <el-select v-model="form.hot" placeholder="请选择是否热门">-->
<!--            <el-option-->
<!--              v-for="dict in hotOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictLabel"-->
<!--              :value="parseInt(dict.dictValue)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="分类ID" prop="categoryId">-->
<!--          <el-input v-model="form.categoryId" placeholder="请输入分类ID" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPosition, getPosition, delPosition, addPosition, updatePosition, exportPosition } from "@/api/recruit/position";
import { mapGetters } from 'vuex'
import { listInfo } from '@/api/recruit/company/info'

export default {
  name: "Position",
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
      // 招聘岗位表格数据
      positionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态字典
      statusOptions: [],
      // 审核状态字典
      auditStateOptions: [],
      // 是否热门字典
      hotOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        requirement: null,
        workCity: null,
        phonenumber: null,
        releaseDate: null,
        validDate: null,
        quantity: null,
        status: null,
        auditState: null,
        salaryUp: null,
        salaryDown: null,
        companyId: null,
        hot: null,
        categoryId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        requirement: [
          { required: true, message: "要求不能为空", trigger: "blur" }
        ],
        workCity: [
          { required: true, message: "工作城市不能为空", trigger: "blur" }
        ],
        phonenumber: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ],
        releaseDate: [
          { required: true, message: "发布时间不能为空", trigger: "blur" }
        ],
        validDate: [
          { required: true, message: "截止日期不能为空", trigger: "blur" }
        ],
        quantity: [
          { required: true, message: "招聘人数不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
        auditState: [
          { required: true, message: "审核状态不能为空", trigger: "blur" }
        ],
        salaryUp: [
          { required: true, message: "最低薪资不能为空", trigger: "blur" }
        ],
        salaryDown: [
          { required: true, message: "最高薪资不能为空", trigger: "blur" }
        ],
        companyId: [
          { required: true, message: "公司ID不能为空", trigger: "blur" }
        ],
        hot: [
          { required: true, message: "是否热门不能为空", trigger: "change" }
        ],
        categoryId: [
          { required: true, message: "分类ID不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("recruit_end_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("recruit_audit_status").then(response => {
      this.auditStateOptions = response.data;
    });
    this.getDicts("recruit_hot").then(response => {
      this.hotOptions = response.data;
    });
  },
  computed:{
    ...mapGetters([
      'userId',
      'isCompany',
    ]),
  },
  methods: {
    /** 查询招聘岗位列表 */
    getList() {
      if (this.isCompany) {//公司查询自己岗位
        this.queryParams.userId = this.userId
      }
      this.loading = true;
      listPosition(this.queryParams).then(response => {
        this.positionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
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
        requirement: null,
        workCity: null,
        phonenumber: null,
        releaseDate: null,
        validDate: null,
        quantity: null,
        status: null,
        auditState: null,
        salaryUp: null,
        salaryDown: null,
        companyId: null,
        hot: null,
        categoryId: null
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
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加招聘岗位";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPosition(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改招聘岗位";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePosition(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            //根据Userid查询他的企业信息，将公司id设置上
            listInfo({userId:this.userId}).then(res=>{
              this.form.companyId=res.rows[0].id
              addPosition(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            })
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除招聘岗位编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delPosition(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有招聘岗位数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportPosition(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
