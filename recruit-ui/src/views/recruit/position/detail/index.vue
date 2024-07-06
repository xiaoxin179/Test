<template>
  <div>
    <div class="brand">
      <MyContainer v-if="position && position.category">
        <el-row :gutter="12">
          <el-col :span="16">
            <p>招聘中</p>
            <h1>{{ position.name }}</h1>
            <p>
              <span>{{ position.workCity }}  </span>
              <el-button style="margin-left: 30px;padding: 3px 0" type="text">{{ position.salaryDown }} -
                {{ position.salaryUp }}
              </el-button>
            </p>
            <p>
              <el-tag size="mini">{{ position.category.parentCategory.categoryName }}</el-tag>
              <el-tag size="mini">{{ position.category.categoryName }}</el-tag>
            </p>
          </el-col>
          <el-col :span="8">
            <el-button type="primary" @click="sendResume" style="width: 100%; margin: 140px 0;">发送简历</el-button>
<!--            <router-link to="/recruit/f/chat">-->
<!--            </router-link>-->
          </el-col>
        </el-row>
      </MyContainer>
    </div>
    <MyContainer>
      <el-row :gutter="12">
        <el-col :span="16">
          <el-tabs v-model="tab">
            <el-tab-pane label="职位要求" name="tab">{{ position.requirement }}</el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col v-if="position.company" :span="8" style="text-align:center;">
          <img :src="position.company.logo" alt="" style="width: 80%;">
          <p>
            <span><i class="el-icon-s-finance"></i>{{ position.company.name }}</span>
<!--            <span><i class="el-icon-s-custom"></i>{{ position.hr.name }}</span>-->
          </p>
          <p>发布于：{{ position.releaseDate }}</p>
          <p>
            {{ position.company.description }}
          </p>
        </el-col>
      </el-row>
    </MyContainer>
  </div>
</template>

<script>
import { getPosition } from '@/api/recruit/position'
import MyContainer from '@/components/Me/MyContainer'
import { addDelivery } from '@/api/recruit/delivery'

export default {
  name: 'Detail',
  components: { MyContainer },
  data() {
    return {
      tab: 'tab',
      position: {}
    }
  },
  methods: {
    getOne() {
      getPosition(this.$route.params.id).then(res => {
        this.position = res.data
        console.log(this.position)
      })
    },
    sendResume() {
      addDelivery({positionId:this.position.id,positionName:this.position.name,companyId:this.position.companyId,companyName:this.position.company.name}).then(res => {
        this.msgSuccess(res.msg)
      })
    }
  },
  created() {
    this.getOne()
  }
}
</script>

<style scoped>
.brand {
  height: 300px;
  color: white;
  background-color: rgb(66, 74, 95);
}
</style>
