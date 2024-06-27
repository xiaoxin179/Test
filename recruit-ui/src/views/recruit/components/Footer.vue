<template>
  <div id="footer" class="">
    <MyContainer>
      <el-row>
        <div>北方民族大学第三次实训项目</div>
      </el-row>
    </MyContainer>
  </div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
export default {
  name: 'Footer',
  components: { MyContainer },
  data() {
    return {}
  },
  methods: {},
  created() {
  }
}
</script>

<style scoped>
a {
  display: block;
  font-size: 12px;
  color: #8d92a1;
  height: 24px;
  line-height: 24px;
}
a img {
  width: 16px;
  height: 16px;
  vertical-align: middle;
}
</style>
