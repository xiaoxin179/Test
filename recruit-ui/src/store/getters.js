const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  userId: state => state.user.userId,
  name: state => state.user.name,
  introduction: state => state.user.introduction,
  roles: state => state.user.roles,
  isCompany: state => state.user.isCompany,
  permissions: state => state.user.permissions,
  permission_routes: state => state.permission.routes,
  sidebarRouters:state => state.permission.sidebarRouters,
}
export default getters
