<template>
<div>
  <MyContainer>
    <el-row>
      <el-col :span="8">
        <el-card v-for="config in userConfigList" shadow="hover">
          <JwChat-item :config="config" @click="bindClick"/>
        </el-card>
      </el-col>
      <el-col :span="16">
        <JwChat :taleList="list"
                @enter="bindEnter"
                v-model="inputMsg"
                :toolConfig="tool"
                :config="chatConfig">
          <template slot="tools">
            <div style="width:100%;text-align:right;" @click="toolEvent('自定义')">
              发送简历<i class="el-icon-s-order"></i>
            </div>
          </template>
        </JwChat>
      </el-col>
    </el-row>
  </MyContainer>
</div>
</template>

<script>
import MyContainer from '@/components/Me/MyContainer'
import { formatDate } from '@/utils'
import { mapGetters } from 'vuex'
import { addMessage, listContact, listMessage } from '@/api/recruit/message'
export default {
  name: 'ChatIndex',
  components: { MyContainer },
  data() {
    return {
      inputMsg: '',
      list: [],
      tool: {
        // 现在只配置了 ["file", "video", "img", "hongbao", "more", "history"]
        show: [''],// 二级数组中放自定义名称
        showEmoji: true, // 是否显示表情图标
        /**
         * @description: 点击按钮的回调函数
         * @param {*} type 当前点击的按钮
         * @param {*} plyload 附加文件或者需要处理的数据
         * @return {*}
         */
        callback: this.toolEvent
      },
      chatConfig: {
        historyConfig: {
          tip: '加载更多',
          /**
           * @description: 点击加载更多的回调函数
           * @return {*}
           */
          callback: () => {
            const history = new Array(3).fill().map((i, j) => {
              return {
                'date': '2020/05/20 23:19:07',
                'text': { 'text': j + new Date() },
                'mine': false,
                'name': 'JwChat',
                'img': 'image/three.jpeg'
              }
            })
            this.list = history.concat(this.list)
          }
        }
      },
      userConfigList: [],
      currentUser:{},//当前联系人
    }
  },
  computed:{
    ...mapGetters([
      'name',
      'avatar',
    ]),
  },
  methods: {
    listMessage(){
      listMessage({sendName:this.name}).then(res=>{
        console.log(res.rows)
      })
    },
    bindClick(play) {
      console.log('获取用户id', play.value.id)
      this.currentUser=play.value
      this.list = [
        {
          'date': '2020/04/25 21:19:07',
          'text': { 'text': '起床不' },
          'mine': false,
          'name': '留恋人间不羡仙',
          'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
        },
        {
          'date': '2020/04/25 21:19:07',
          'text': { 'text': '起床不' },
          'mine': true,
          'name': '留恋人间不羡仙',
          'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
        }
      ]
    },
    bindEnter() {//回车发送消息
      const msg = this.inputMsg
      if (!msg) return
      const msgObj = {
        'date': formatDate(new Date()),
        'text': { 'text': msg },
        'mine': true,
        'name': this.name,
        'img': this.avatar
      }
      //添加到信息表
      let {id,name,img}=this.currentUser
      addMessage({receiveId:id,receiveName:name,content:msg,avatar:img})
      this.list.push(msgObj)
    },
    toolEvent(type, plyload) {
      console.log('tools', type, plyload)
    }
  },
  created() {
    this.listMessage()
    listContact().then(res=>{
      res.data.forEach(v=>{
        this.userConfigList.push({
          id:v.receiveId,
          img: v.avatar,
          name: v.receiveName,
          dept: v.createTime,
        })
      })
      this.currentUser=this.userConfigList[0]
    })
  },
  mounted() {
    const img = 'https://www.baidu.com/img/flexible/logo/pc/result.png'
    this.list = [
      {
        'date': '2020/04/25 21:19:07',
        'text': { 'text': '起床不' },
        'mine': false,
        'name': '留恋人间不羡仙',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
      },
      {
        'date': '2020/04/25 21:19:07',
        'text': { 'text': '起床不' },
        'mine': false,
        'name': '留恋人间不羡仙',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
      },
      {
        'date': '2020/04/25 21:19:07',
        'text': { 'text': '<audio data-src=\'https://www.w3school.com.cn/i/horse.mp3\'/>' },
        'mine': false,
        'name': '只盼流星不盼雨',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
      },
      {
        'date': '2020/04/25 21:19:07',
        'text': { 'text': '<img data-src=\'' + img + '\'/>' },
        'mine': false,
        'name': '只盼流星不盼雨',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
      },
      {
        'date': '2020/04/25 21:19:07',
        'text': { 'text': '<img data-src=\'/image/three.jpeg\'/>' },
        'mine': false,
        'name': '只盼流星不盼雨',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/two.jpeg'
      },
      {
        'date': '2020/04/16 21:19:07',
        'text': { 'text': '<video data-src=\'https://www.w3school.com.cn/i/movie.mp4\' controls=\'controls\' />' },
        'mine': true,
        'name': 'JwChat',
        'img': 'https://codegi.gitee.io/jwchatdoc/image/three.jpeg'
      }
    ]
  }
}
</script>

<style scoped>
</style>
