import request from '@/utils/request'

// 查询招聘岗位列表
export function listPosition(query) {
  return request({
    url: '/recruit/position/list',
    method: 'get',
    params: query
  })
}

// 查询招聘岗位详细
export function getPosition(id) {
  return request({
    url: '/recruit/position/' + id,
    method: 'get'
  })
}

// 新增招聘岗位
export function addPosition(data) {
  return request({
    url: '/recruit/position',
    method: 'post',
    data: data
  })
}

// 修改招聘岗位
export function updatePosition(data) {
  return request({
    url: '/recruit/position',
    method: 'put',
    data: data
  })
}

// 删除招聘岗位
export function delPosition(id) {
  return request({
    url: '/recruit/position/' + id,
    method: 'delete'
  })
}

// 导出招聘岗位
export function exportPosition(query) {
  return request({
    url: '/recruit/position/export',
    method: 'get',
    params: query
  })
}