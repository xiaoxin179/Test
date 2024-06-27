import request from '@/utils/request'

// 查询学生个人信息列表
export function listStudent(query) {
  return request({
    url: '/recruit/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生个人信息详细
export function getStudent(id) {
  return request({
    url: '/recruit/student/' + id,
    method: 'get'
  })
}

// 新增学生个人信息
export function addStudent(data) {
  return request({
    url: '/recruit/student',
    method: 'post',
    data: data
  })
}

// 修改学生个人信息
export function updateStudent(data) {
  return request({
    url: '/recruit/student',
    method: 'put',
    data: data
  })
}

// 删除学生个人信息
export function delStudent(id) {
  return request({
    url: '/recruit/student/' + id,
    method: 'delete'
  })
}

// 导出学生个人信息
export function exportStudent(query) {
  return request({
    url: '/recruit/student/export',
    method: 'get',
    params: query
  })
}