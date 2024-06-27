import request from '@/utils/request'

// 查询岗位大分类列表
export function listBigCategory(query) {
  return request({
    url: '/recruit/category/big',
    method: 'get',
    params: query
  })
}

// 查询岗位分类列表
export function listCategory(query) {
  return request({
    url: '/recruit/category/list',
    method: 'get',
    params: query
  })
}

// 查询岗位分类详细
export function getCategory(id) {
  return request({
    url: '/recruit/category/' + id,
    method: 'get'
  })
}

// 新增岗位分类
export function addCategory(data) {
  return request({
    url: '/recruit/category',
    method: 'post',
    data: data
  })
}

// 修改岗位分类
export function updateCategory(data) {
  return request({
    url: '/recruit/category',
    method: 'put',
    data: data
  })
}

// 删除岗位分类
export function delCategory(id) {
  return request({
    url: '/recruit/category/' + id,
    method: 'delete'
  })
}

// 导出岗位分类
export function exportCategory(query) {
  return request({
    url: '/recruit/category/export',
    method: 'get',
    params: query
  })
}
