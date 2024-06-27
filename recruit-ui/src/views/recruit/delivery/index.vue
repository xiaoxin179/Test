<template>
  <MyContainer>
    <el-card v-for="delivery in deliveryList" :key="delivery.id">
      <div slot="header" class="clearfix">
        <span>{{ delivery.positionName }}</span>
        <el-button @click="delDelivery(delivery.id)" style="float: right; padding: 3px 0" type="text" icon="el-icon-delete">删除</el-button>
      </div>
      <div>
        <el-row :gutter="12">
          <el-col :span="4">
<!--            <img :src="delivery.company.logo" alt="">-->
          </el-col>
          <el-col :span="4">
            <p><i class="el-icon-s-finance"></i>{{delivery.companyName}}</p>
          </el-col>
          <el-col :span="4">
            <p>薪资：<el-button style="padding: 3px 0" type="text">
              {{ delivery.position.salaryDown }} - {{ delivery.position.salaryUp }}
            </el-button>
            </p>
          </el-col>
          <el-col :span="4">
            <p>时间：{{ delivery.position.releaseDate }}</p>
          </el-col>
          <el-col :span="4">
            <p>{{statusFormat(delivery.status)}}</p>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </MyContainer>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import { mapGetters } from 'vuex'
import { delDelivery, listDelivery } from '@/api/recruit/delivery'

export default {
  name: 'Delivery',
  components: { MyContainer },
  data() {
    return {
      deliveryList: [],
      // 0：未处理，1：通过，2：拒绝 状态字典
      statusOptions: [],
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar'
    ])
  },
  methods: {
    listDelivery() {
      listDelivery({ userName: this.name }).then(res => {
        this.deliveryList = res.rows
      })
    },
    delDelivery(id) {
      delDelivery(id).then(res => {
        this.msgSuccess(res.msg)
        this.listDelivery()
      })
    },
    // 0：未处理，1：通过，2：拒绝字典翻译
    statusFormat(value) {
      return this.selectDictLabel(this.statusOptions, value);
    }
  },
  created() {
    this.listDelivery()
    this.getDicts("recruit_audit_status").then(response => {
      this.statusOptions = response.data;
    });
  }
}
</script>

<style scoped>
img {
  height: 80px;
}
</style>
