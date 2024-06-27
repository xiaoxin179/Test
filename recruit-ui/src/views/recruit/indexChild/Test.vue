<template>
  <div>
  <Banner/>
  <Search/>
  <IndexMain/>
  </div>
</template>

<script>
import Search from '@/views/recruit/components/Search'
import Banner from '@/views/recruit/components/Banner'
import MyContainer from '@/components/Me/MyContainer'
import IndexMain from '@/views/recruit/indexChild/main'

export default {
  name: 'Test',
  components: { IndexMain, MyContainer, Banner, Search },
}
</script>
<style scoped lang="scss">
.flex {
  height: 50px;
  display: flex;
  justify-content: center;
}
.text1,.text2 {
}
.text1{
  background-color: #00afff;
}
.text2{
  background-color: #E65D6E;
}
</style>
