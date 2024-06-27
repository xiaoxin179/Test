<template>
  <div class="w">
    <Search/>
    <MyContainer>
      <el-row :gutter="12">
        <el-col :span="16">
          <el-card v-for="position in positionList" shadow="hover">
            <el-row :gutter="12">
              <el-col :span="12">
                <h3>
                  <router-link :to="'/recruit/f/detail/'+position.id">{{ position.name }}</router-link>
                  <el-button style="margin-left: 30px;padding: 3px 0" type="text">{{ position.salaryDown }} - {{ position.salaryUp }}</el-button>
                </h3>
                <p>
                  <span>{{ position.workCity}}</span>
                  <el-tag size="mini">{{ position.category.parentCategory.categoryName }}</el-tag>
                  <el-tag size="mini">{{ position.category.categoryName }}</el-tag>
                  <span>发布于：{{ position.releaseDate }}</span>
                </p>
              </el-col>
              <el-col :span="4" :offset="4">
                <p><i class="el-icon-s-finance"></i>{{position.company.name}}</p>
<!--                <p><i class="el-icon-s-custom"></i>{{position.hr.name}}</p>-->
              </el-col>
              <el-col :span="4">
                <img :src="position.company.logo" alt="">
              </el-col>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="8">
          <Ad/>
        </el-col>
      </el-row>
    </MyContainer>
  </div>
</template>

<script>
import Search from '@/views/recruit/components/Search'
import MyContainer from '@/components/Me/MyContainer'
import { listPosition } from '@/api/recruit/position'
import Ad from '@/views/recruit/components/Ad'
export default {
  name: 'Position',
  components: { Ad, MyContainer, Search },
  data() {
    return {
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      positionList:[],
    }
  },
  methods: {
    listPosition(){
      listPosition(this.queryParams).then(response => {
        this.positionList = response.rows;
        this.positionList.forEach(value => {
          console.log(JSON.stringify(value.category))
        })
      });
    }
  },
  created() {
    this.listPosition()
  }
}
</script>

<style scoped lang="scss">
.w {
  background-color: rgb(246,246,248);
  .el-card {
    p{
      span {
        font-size: 13px;
        color: #8d92a1;
        margin-right: 10px;
      }
      .el-tag {
        margin-right: 10px;
      }
    }
    img{
      width: 100%;
    }
  }
}
</style>
