import request from '@/utils/request'

// 查询讲座申请列表
export function listLecture(query) {
  return request({
    url: '/recruit/lecture/list',
    method: 'get',
    params: query
  })
}
export function myLecture() {
  return request({
    url: '/recruit/lecture/my',
    method: 'get'
  })
}

// 查询讲座申请详细
export function getLecture(id) {
  return request({
    url: '/recruit/lecture/' + id,
    method: 'get'
  })
}

// 新增讲座申请
export function addLecture(data) {
  return request({
    url: '/recruit/lecture',
    method: 'post',
    data: data
  })
}

// 修改讲座申请
export function updateLecture(data) {
  return request({
    url: '/recruit/lecture',
    method: 'put',
    data: data
  })
}

// 删除讲座申请
export function delLecture(id) {
  return request({
    url: '/recruit/lecture/' + id,
    method: 'delete'
  })
}

// 导出讲座申请
export function exportLecture(query) {
  return request({
    url: '/recruit/lecture/export',
    method: 'get',
    params: query
  })
}
