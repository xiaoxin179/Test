import request from '@/utils/request'

// 企业注册
export function register(data) {
    return request({
        url: '/recruit/register',
        method: 'post',
        data: data
    })
}

export function common(url,data) {
    return request({
        url: url,
        method: 'post',
        data: data
    })
}
