import request from '@/utils/request'
//统计企业下发的HC数量排行榜
export function getSumHc(query) {
  return request({
    url: 'data/sumHC',
    method: 'get',
  })
}
export function getTop6(query) {
  return request({
    url: 'data/top6',
    method: 'get',
  })
}
