import request from '@/utils/request'

// 查询学生简历信息列表
export function listResume(query) {
  return request({
    url: '/recruit/resume/list',
    method: 'get',
    params: query
  })
}
export function companyListResume(query) {
  return request({
    url: '/recruit/resume/company',
    method: 'get',
    params: query
  })
}

// 查询学生简历信息详细
export function getResume(id) {
  return request({
    url: '/recruit/resume/' + id,
    method: 'get'
  })
}

// 新增学生简历信息
export function addResume(data) {
  return request({
    url: '/recruit/resume',
    method: 'post',
    data: data
  })
}

// 修改学生简历信息
export function updateResume(data) {
  return request({
    url: '/recruit/resume',
    method: 'put',
    data: data
  })
}

// 删除学生简历信息
export function delResume(id) {
  return request({
    url: '/recruit/resume/' + id,
    method: 'delete'
  })
}

// 导出学生简历信息
export function exportResume(query) {
  return request({
    url: '/recruit/resume/export',
    method: 'get',
    params: query
  })
}
