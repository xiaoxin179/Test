import request from '@/utils/request'

// 查询教室列表
export function listClassroom(query) {
  return request({
    url: '/recruit/classroom/list',
    method: 'get',
    params: query
  })
}

// 查询教室详细
export function getClassroom(id) {
  return request({
    url: '/recruit/classroom/' + id,
    method: 'get'
  })
}

// 新增教室
export function addClassroom(data) {
  return request({
    url: '/recruit/classroom',
    method: 'post',
    data: data
  })
}

// 修改教室
export function updateClassroom(data) {
  return request({
    url: '/recruit/classroom',
    method: 'put',
    data: data
  })
}

// 删除教室
export function delClassroom(id) {
  return request({
    url: '/recruit/classroom/' + id,
    method: 'delete'
  })
}

// 导出教室
export function exportClassroom(query) {
  return request({
    url: '/recruit/classroom/export',
    method: 'get',
    params: query
  })
}