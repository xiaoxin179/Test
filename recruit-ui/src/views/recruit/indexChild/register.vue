<template>
  <div style="height: 93vh;overflow: hidden;background:rgb(93,213,200) url(https://static.zhipin.com/zhipin-geek/v364/web/geek/images/newbg.png) no-repeat center bottom;">
    <div class="form-wrap clearfix">
      <el-col :span="8">
        <h3>沟通</h3>
        <p>在线职位及时沟通</p>
        <h3>任性选</h3>
        <p>各大行业职位任你选</p>
      </el-col>
      <el-col :span="16">
        <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
          <el-form-item label="用户昵称" prop="user.nickName">
            <el-input v-model="formData.user.nickName" placeholder="请输入用户昵称" />
          </el-form-item>
          <el-form-item label="用户账号" prop="user.userName">
            <el-input v-model="formData.user.userName" placeholder="请输入用户账号" />
          </el-form-item>
          <el-form-item label="用户密码" prop="user.password">
            <el-input v-model="formData.user.password" placeholder="请输入用户密码" type="password" />
          </el-form-item>
          <el-form-item label="联系电话" prop="user.phonenumber">
            <el-input v-model="formData.user.phonenumber" placeholder="请输入联系电话" :maxlength="11" show-word-limit clearable
                      prefix-icon='el-icon-mobile' :style="{width: '100%'}"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="user.email">
            <el-input v-model="formData.user.email" placeholder="请输入邮箱" maxlength="50" />
          </el-form-item>
          <el-form-item label="公司名称" prop="companyInfo.name">
            <el-input v-model="formData.companyInfo.name" placeholder="请输入公司名称" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
          <el-form-item label="公司地址" prop="companyInfo.address">
            <el-input v-model="formData.companyInfo.address" placeholder="请输入公司地址" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item label="企业性质" prop="companyInfo.nature">
                <el-select v-model="formData.companyInfo.nature" placeholder="请选择企业性质" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in natureOptions" :key="index" :label="item.label"
                             :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="企业描述" prop="description">
            <el-input v-model="formData.companyInfo.description" type="textarea" placeholder="请输入企业描述"
                      :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
          </el-form-item>
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </div>
  </div>
</template>
<script>
import MyContainer from '@/components/Me/MyContainer'
import { common, register } from '@/api/recruit/company/register'
export default {
  components: { MyContainer },
  props: [],
  data() {
    return {
      // 性别状态字典
      sexOptions: [],
      formData: {
        user:{},
        companyInfo:{
          name: '',
          address: '',
          nature: undefined,
          description: undefined,
        }
      },
      rules: {
        "user.userName": [{
          required: true,
          message: '请输入账号名称',
          trigger: 'blur'
        }],
        "user.nickName": [{
          required: true,
          message: '请输入账号名称',
          trigger: 'blur'
        }],
        "user.phonenumber": [{
          required: true,
          message: '请输入联系电话',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        "user.password": [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }],
        "companyInfo.name": [{
          required: true,
          message: '请输入公司名称',
          trigger: 'blur'
        }],
        "companyInfo.address": [{
          required: true,
          message: '请输入公司地址',
          trigger: 'blur'
        }],
        "companyInfo.nature": [{
          required: true,
          message: '请选择企业性质',
          trigger: 'change'
        }],
        "companyInfo.description": [],
      },
      natureOptions: [{
        "label": "私企",
        "value": 0
      }, {
        "label": "国企",
        "value": 1
      }],
    }
  },
  computed: {},
  watch: {},
  created() {
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
  },
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (valid) {
          register(this.formData).then(response => {
            if (response.code === 200) {
              this.$message.success(response.msg)
              this.$router.push("/login")
            } else {
              this.$message.error(response.msg);
            }
          })
        }
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style scoped>
.el-upload__tip {
  line-height: 1.2;
}
.form-wrap {
  padding: 30px;
  width: 60%;
  margin: 50px auto 0;
  background: #fff;
  box-shadow: 0 6px 13px 0 rgba(0,0,0,.1);
  border-radius: 10px;
}
</style>
