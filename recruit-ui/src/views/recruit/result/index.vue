<template>
  <MyContainer>
    <el-row :gutter="12">
      <el-col v-for="position in positionList" :span="8">
        <el-card shadow="hover">
          <div slot="header" class="clearfix">
            <router-link :to="'/recruit/f/detail/'+position.id">{{ position.name }}</router-link>
            <el-button style="float: right; padding: 3px 0" type="text">{{ position.salaryDown }} - {{ position.salaryUp }}</el-button>
            <p>
              <span>{{ position.workCity}}</span>
              <el-tag size="mini">{{ position.category.parentCategory.categoryName }}</el-tag>
              <el-tag size="mini">{{ position.category.categoryName }}</el-tag>
            </p>
          </div>
          <el-row :gutter="12">
            <el-col :span="2">
              <img :src="position.company.logo" alt="">
            </el-col>
            <el-col :span="18">{{position.company.name}}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </MyContainer>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import { listPosition } from '@/api/recruit/position'
export default {
  name: 'Result',
  components: { MyContainer },
  data() {
    return {
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 20
      },
      positionList:[],
    }
  },
  methods: {
    search(){
      this.queryParams.name = this.$route.query.name
      listPosition(this.queryParams).then(res=>{
        this.positionList=res.rows
      })
    }
  },
  created() {
    this.search()
  }
}
</script>

<style scoped>
.el-card {
  margin-bottom: 10px;
  height: 160px;
}
img {
  width: 100%;
}
p span {
  font-size: 13px;
  color: #8d92a1;
}
p span,.el-tag {
  margin-right: 10px;
}
</style>
