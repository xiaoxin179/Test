import request from '@/utils/request'

// 查询简历投递信息列表
export function listDelivery(query) {
  return request({
    url: '/recruit/delivery/list',
    method: 'get',
    params: query
  })
}

// 查询简历投递信息详细
export function getDelivery(id) {
  return request({
    url: '/recruit/delivery/' + id,
    method: 'get'
  })
}

// 新增简历投递信息
export function addDelivery(data) {
  return request({
    url: '/recruit/delivery',
    method: 'post',
    data: data
  })
}

// 修改简历投递信息
export function updateDelivery(data) {
  return request({
    url: '/recruit/delivery',
    method: 'put',
    data: data
  })
}

// 删除简历投递信息
export function delDelivery(id) {
  return request({
    url: '/recruit/delivery/' + id,
    method: 'delete'
  })
}

// 导出简历投递信息
export function exportDelivery(query) {
  return request({
    url: '/recruit/delivery/export',
    method: 'get',
    params: query
  })
}