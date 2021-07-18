<template>

  <v-app>
      <v-system-bar color="cyan"></v-system-bar>
      <v-app-bar app color="light-blue" dark>
        <v-toolbar-title>
          <router-link style="cursor: pointer" tag="span" to="/">
            {{ appTitle }}
          </router-link>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
          <v-btn
              v-for="item in headerItems"
              :key="item.title"
              :to="item.path"
              flat>
            <v-icon dark left>{{ item.icon }}</v-icon>
            {{ item.title }}
          </v-btn>
        </v-toolbar-items>
      </v-app-bar>
<!--      <v-navigation-drawer bottom>-->
<!--        &lt;!&ndash; &ndash;&gt;-->
<!--      </v-navigation-drawer>-->


      <!-- アプリケーションのコンポーネントに基づいてコンテンツのサイズを決定 -->
      <v-main>
          <!-- vue-routerを使用している場合 -->
          <router-view></router-view>
      </v-main>

      <v-footer app>
        <!-- -->
      </v-footer>
  </v-app>
</template>
<script>
export default {
  name: "App",
  data() {
    return {
      appTitle: 'Kanban App',
      sidebar: false,
      headerItems: [
        {title: 'Dashboard', path: '/dashboard', icon: 'mdi-view-dashboard'},
        {title: 'Calender', path: '/calendar', icon: 'mdi-calendar-month'},
        {title: 'Account', path: '/account', icon: 'mdi-account-box'},
        {title: 'Admin', path: '/admin', icon: 'mdi-gavel'},
      ]
    }
  }
}
</script>


<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
