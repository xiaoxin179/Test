<template>
  <div class="app-container home">
    <div>
      <lunbo></lunbo>
    </div>
    <div >
      <div >
        <div style="display: flex">
          <div style="margin-left:100px">
            <span>企业招聘总人数排行</span>
            <dv-scroll-ranking-board :config="config" style="width:500px;height:400px;color: black" />
          </div>
          <div style="margin-left: 400px">
            <span style="margin-left: 120px">岗位最多的六个城市</span>
            <dv-capsule-chart :config="config2" style="width:400px;height:400px;color: black" />
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import indexData from "@/components/Me/indexData.vue";
import lunbo from "@/components/Me/lunbo.vue"
import data, {getSumHc, getTop6} from "@/api/recruit/data"
export default {
  name: "index",
  components:{
    indexData,
    lunbo
  },
  data() {
    return {
      config:{data:[]},
      config2:{data:[
          {
            name: '南阳',
            value: 167
          },
          {
            name: '周口',
            value: 67
          },
        ]},
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    async getSumofHC() {
      try {
        const res = await getSumHc();
        this.config = {
          data: res.data.map(item => ({
            name: item.name,
            value: item.value
          }))
        };
        this.config.waitTime=900;
      } catch (error) {
        console.error(error);
      }
    },
    async getTop6() {
      try {
        const res = await getTop6();
        console.log(res.data)
        this.config2 = {
          data: res.data.map(item => ({
            name: item.name,
            value: item.value
          }))
        };
      } catch (error) {
        console.error(error);
      }
    }

  },
  mounted() {
    this.getSumofHC()
    this.getTop6()
  }
}
</script>

<style scoped lang="scss">
#mapBox{
  width: 60%;
  height: 60vh;
  background-color: #065990;
  margin-left: 10%;
  padding-bottom: 3%;
  border-radius: 10px;
}
</style>

