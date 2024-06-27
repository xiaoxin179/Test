<template>
  <el-row>
    <el-col :span="12">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="公司LOGO" prop="logo">
          <ImageUpload v-model="logo" @uploadSuccess="uploadLogo"/>
        </el-form-item>
        <el-form-item label="营业执照" prop="license">
          <ImageUpload v-model="license" @uploadSuccess="uploadLicense"/>
        </el-form-item>
      </el-form>
    </el-col>
    <el-col :span="12">
      <el-alert
        :title="statusList[company.auditState]"
        type="info">
      </el-alert>
      <h2>温馨提示:</h2>
      <p>重新上传logo或者营业执照将会重新审核！</p>
    </el-col>
  </el-row>
</template>

<script>
import ImageUpload from '@/components/ImageUpload'
import { listInfo, updateInfo } from '@/api/recruit/company/info'
import { mapGetters } from 'vuex'

export default {
  name: 'companyInfo',
  components: { ImageUpload },
  data() {
    return {
      logo:'',
      license:'',
      form:{},
      statusList:['未上传',
        '审核中',
        '通过',
        '驳回'],
      company:{}
    }
  },
  methods: {
    uploadLogo(url) {
      updateInfo({ id:this.company.id,userId:this.userId,logo:url ,auditState:1}).then(res=>{
        this.alertMsg(res.msg)
        location.reload()
      })
    },
    uploadLicense(url) {
      updateInfo({ id:this.company.id,userId:this.userId,license:url ,auditState:1}).then(res=>{
        this.alertMsg(res.msg)
        location.reload()
      })
    },
    alertMsg(msg) {
      this.$alert('修改成功！请等待管理员审核！', msg, {
        confirmButtonText: '确定',
      });
    }
  },
  computed: {
    ...mapGetters([
      'userId',
    ]),
  },
  created() {
    listInfo({userId:this.userId}).then(res=>{
      this.company=res.rows[0]
      this.logo=this.company.logo
      this.license=this.company.license
    })
  }
}
</script>

<style scoped>

</style>
