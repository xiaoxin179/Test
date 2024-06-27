<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户账号" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户账号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="岗位名称" prop="positionName">
        <el-input
          v-model="queryParams.positionName"
          placeholder="请输入岗位名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投递状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择投递状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item v-if="isCompany" label="公司名称" prop="companyName">
        <el-input
          v-model="queryParams.companyName"
          placeholder="请输入公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
<!--          v-hasPermi="['recruit:delivery:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['recruit:delivery:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['recruit:delivery:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruit:delivery:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="deliveryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="用户账号" align="center" prop="userName">
        <template slot-scope="scope">
          <el-tag size="medium" @click="seeResume(scope.row)">{{ scope.row.userName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="岗位信息ID" align="center" prop="positionId" />
      <el-table-column label="岗位名称" align="center" prop="positionName" />
      <el-table-column label="投递状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="公司ID" align="center" prop="companyId" />
      <el-table-column label="公司名称" align="center" prop="companyName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['recruit:delivery:edit']"
          >审核</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruit:delivery:remove']"
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

    <!-- 添加或修改简历投递信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="用户ID" prop="userId">-->
<!--          <el-input v-model="form.userId" placeholder="请输入用户ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="用户账号" prop="userName">-->
<!--          <el-input v-model="form.userName" placeholder="请输入用户账号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="岗位信息ID" prop="positionId">-->
<!--          <el-input v-model="form.positionId" placeholder="请输入岗位信息ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="岗位名称" prop="positionName">-->
<!--          <el-input v-model="form.positionName" placeholder="请输入岗位名称" />-->
<!--        </el-form-item>-->
        <el-form-item label="投递状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择投递状态">
            <el-option
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="公司ID" prop="companyId">-->
<!--          <el-input v-model="form.companyId" placeholder="请输入公司ID" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="公司名称" prop="companyName">-->
<!--          <el-input v-model="form.companyName" placeholder="请输入公司名称" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 简历信息对话框 -->
    <el-dialog title="简历信息" :visible.sync="resumeVisible" width="500px">
      <ul class="list-group list-group-striped">
        <li v-for="(enKey,index) in enList" class="list-group-item">
          {{ zhList[index] }}
          <div class="pull-right">{{ enKey==='sex'?sexFormat(resume[enKey]):resume[enKey] }}</div>
        </li>
        <li class="list-group-item">
          简历附件
          <div class="pull-right">
            <a :href="resume.url" download>点击下载</a>
          </div>
        </li>
      </ul>
      <span slot="footer" class="dialog-footer">
        <el-button @click="resumeVisible = false">取 消</el-button>
        <el-button type="danger" @click="updDelivery(2)">拒绝</el-button>
        <el-button type="success" @click="updDelivery(1)">通过</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import { listDelivery, getDelivery, delDelivery, addDelivery, updateDelivery, exportDelivery } from "@/api/recruit/delivery";
import { mapGetters } from 'vuex'
import { listResume } from '@/api/recruit/resume'
import { companyListResume } from '../../../../api/recruit/resume'

export default {
  name: "Delivery",
  components: {
  },
  computed: {
    ...mapGetters([
      'userId',
      'isCompany',
    ]),
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
      // 简历投递信息表格数据
      deliveryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示简历弹出层
      resumeVisible: false,
      resume: {},
      //通过或者拒绝时的简历id
      resumeId: 0,
      // 性别字典
      sexOptions: [],
      enList: [
        'userName',
        'sex',
        'minority',
        'height',
        'weight',
        'politicalOutlook',
        'highestEducation',
        'health',
        'jobIntention',
        'birthday',
        'major',
        'currentResidence',
        'postalAddress',
        'phone',
        'email',
        'awards',
        'professionalCourses',
        'selfEvaluation',
      ],
      zhList: ['姓名',
        '性别',
        '民族',
        '身高',
        '体重',
        '政治面貌',
        '最高学历',
        '健康状况',
        '求职意向',
        '出生年月',
        '所学专业',
        '现居住地',
        '通讯地址',
        '联系电话',
        '邮箱',
        '所获奖项',
        '专业课程',
        '自我评价',],
      // 投递状态字典
      statusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        userName: null,
        positionName: null,
        status: null,
        companyName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户账号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("recruit_audit_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
  },
  methods: {
    /** 查询简历投递信息列表 */
    getList() {
      this.loading = true;
      //如果是企业，只查询投给自己的简历
      if (this.isCompany) {
        this.queryParams.userId=this.userId
      }
      listDelivery(this.queryParams).then(response => {
        this.deliveryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 投递状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
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
        userId: null,
        userName: null,
        positionId: null,
        positionName: null,
        status: null,
        companyId: null,
        companyName: null
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
      this.title = "添加简历投递信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDelivery(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改简历投递信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDelivery(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDelivery(this.form).then(response => {
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
      this.$confirm('是否确认删除简历投递信息编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delDelivery(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有简历投递信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportDelivery(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    },
    // 性别字典翻译
    sexFormat(value) {
      return this.selectDictLabel(this.sexOptions, value);
    },
    seeResume(row){
      this.resumeId=row.id;
      companyListResume({userId:row.userId}).then(res=>{
        this.resume=res.rows[0]
        this.resumeVisible=true
      })
    },
    updDelivery(status){
      updateDelivery({id:this.resumeId,status:status}).then(res=>{
        this.msgSuccess(res.msg);
        this.getList()
        this.resumeVisible=false
      })
    }
  }
};
</script>
