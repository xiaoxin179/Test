<template>
<MyContainer>
  <el-card v-for="lecture in lectureList">
    <div slot="header">
      <h2>{{ lecture.companyName }}</h2>
    </div>
    <div>
      <el-form label-width="80px">
        <el-form-item label="电话">{{ lecture.phone}}</el-form-item>
        <el-form-item label="公司简介">{{ lecture.description}}</el-form-item>
        <el-form-item label="地点">{{ lecture.classroom}}</el-form-item>
        <el-form-item label="方向">{{ lecture.direct}}</el-form-item>
        <el-form-item label="时间">{{ lecture.startTime}}</el-form-item>
      </el-form>
    </div>
  </el-card>
</MyContainer>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import { listLecture } from '@/api/recruit/lecture'
import { listClassroom } from '@/api/recruit/classroom'
export default {
  name: 'index',
  components: { MyContainer },
  data() {
    return {
      // 讲座数据
      lectureList: [],
    }
  },
  methods: {
    /** 查询讲座申请列表 */
    getList() {
      listLecture({auditState:1}).then(response => {
        this.lectureList = response.rows;
      });
    },
  },
  created() {
    this.getList();
  }
}
</script>

<style scoped>

</style>
