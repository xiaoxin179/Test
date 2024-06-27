<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="公司名称" prop="companyName">
        <el-input
          v-model="queryParams.companyName"
          placeholder="请输入公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司地址" prop="companyAddress">
        <el-input
          v-model="queryParams.companyAddress"
          placeholder="请输入公司地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入联系电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="方向" prop="direct">
        <el-input
          v-model="queryParams.direct"
          placeholder="请输入方向"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开讲座时间" prop="startTime">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.startTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择开讲座时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="宣讲座地点" prop="classroom">
        <el-input
          v-model="queryParams.classroom"
          placeholder="请输入宣讲座地点"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
<!--      <el-form-item label="申请类型" prop="type">-->
<!--        <el-select v-model="queryParams.type" placeholder="请选择申请类型" clearable size="small">-->
<!--          <el-option label="请选择字典生成" value="" />-->
<!--        </el-select>-->
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
          v-hasPermi="['recruit:lecture:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['recruit:lecture:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['recruit:lecture:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruit:lecture:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lectureList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申请类型" align="center" prop="id" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="公司地址" align="center" prop="companyAddress" />
      <el-table-column label="企业描述" align="center" prop="description" />
      <el-table-column label="联系电话" align="center" prop="phone" />
      <el-table-column label="方向" align="center" prop="direct" />
      <el-table-column label="开讲座时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="宣讲座地点" align="center" prop="classroom" />
      <el-table-column label="审核状态" align="center" prop="auditState" :formatter="auditStateFormat" />
<!--      <el-table-column label="申请类型" align="center" prop="type" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['recruit:lecture:edit']"
          >审核</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruit:lecture:remove']"
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

    <!-- 添加或修改讲座申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="公司名称" prop="companyName">
          <el-input v-model="form.companyName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="公司地址" prop="companyAddress">
          <el-input v-model="form.companyAddress" placeholder="请输入公司地址" />
        </el-form-item>
        <el-form-item label="企业描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="联系电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="方向" prop="direct">
          <el-input v-model="form.direct" placeholder="请输入方向" />
        </el-form-item>
        <el-form-item label="时间" prop="startTime">
          <el-date-picker
            v-model="form.startTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="宣讲座地点" prop="classroom">
          <el-select v-model="form.classroom" placeholder="请选择宣讲座地点" clearable size="small">
            <el-option
              v-for="item in classroomList"
              :key="item.id"
              :label="item.classroom"
              :value="item.classroom"
            />
          </el-select>
        </el-form-item>
        <el-form-item v-if="form.id" label="审核状态" prop="auditState">
          <el-select v-model="form.auditState" placeholder="请选择审核状态">
            <el-option
              v-for="dict in auditStateOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="申请类型" prop="type">-->
<!--          <el-select v-model="form.type" placeholder="请选择申请类型">-->
<!--            <el-option label="请选择字典生成" value="" />-->
<!--          </el-select>-->
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
import {
  listLecture,
  getLecture,
  delLecture,
  addLecture,
  updateLecture,
  exportLecture,
  myLecture
} from '@/api/recruit/lecture'
import { listClassroom } from '@/api/recruit/classroom'
import { listInfo } from '@/api/recruit/company/info'
import { mapGetters } from 'vuex'

export default {
  name: "Lecture",
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
      // 讲座申请表格数据
      lectureList: [],
      classroomList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 审核状态字典
      auditStateOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        companyName: null,
        companyAddress: null,
        phone: null,
        direct: null,
        startTime: null,
        classroom: null,
        auditState: null,
        type: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
    };
  },
  computed: {
    ...mapGetters([
      'userId',
      'isCompany'
    ])
  },
  created() {
    this.getList();
    this.getDicts("recruit_audit_status").then(response => {
      this.auditStateOptions = response.data;
    });
  },
  methods: {
    /** 查询讲座申请列表 */
    getList() {
      this.loading = true;
      if (this.isCompany) {
        myLecture().then(response => {
          this.lectureList = response.rows
          this.total = response.total
          this.loading = false
        })
      } else {
        listLecture(this.queryParams).then(response => {
          this.lectureList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      }
      /** 查询教室列表 */
      listClassroom({occupied:0}).then(response => {
        this.classroomList = response.rows;
      });
    },
    // 审核状态字典翻译
    auditStateFormat(row, column) {
      return this.selectDictLabel(this.auditStateOptions, row.auditState);
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
        companyName: null,
        companyAddress: null,
        phone: null,
        direct: null,
        startTime: null,
        classroom: null,
        auditState: null,
        type: null
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
      this.title = "添加讲座申请";
      /** 查询当前登录用户的公司，用于申请讲座展示 */
      listInfo({userId: this.userId}).then(response => {
        let {name,address, description,phonenumber}=response.rows[0]
        this.form={companyName:name,companyAddress:address,phone:phonenumber,description}
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLecture(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改讲座申请";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLecture(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLecture(this.form).then(response => {
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
      this.$confirm('是否确认删除讲座申请编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delLecture(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有讲座申请数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportLecture(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
