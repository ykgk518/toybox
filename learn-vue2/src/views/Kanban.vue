<template>
  <v-app>
    <v-app-bar
        app
        color="blue"
        dark
    >
      <div class="d-flex align-center">
        <v-icon>mdi-menu</v-icon>
        {{ appTitle }}
      </div>

      <v-spacer></v-spacer>

      <v-btn
          href="https://github.com/vuetifyjs/vuetify/releases/latest"
          target="_blank"
          text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-toolbar>
      <v-toolbar-title>
        {{ appTitle }}
      </v-toolbar-title>
    </v-toolbar>

    <v-main>
      Hell World
    </v-main>
    <v-card
        class="mx-auto"
        height="400"
        width="256"
    >
      <v-navigation-drawer
          class="deep-purple accent-4"
          dark
          permanent
      >
        <v-list>
          <v-list-item
              v-for="item in sidebarItems"
              :key="item.title"
              link
          >
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <template v-slot:append>
          <div class="pa-2">
            <v-btn block>
              Logout
            </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
    </v-card>
  </v-app>

</template>

<script>
export default {
  name: "Kanban",
  data() {
    return {
      appTitle: 'Kanban App',
      sidebarItems: [
        { title: 'Dashboard', icon: 'mdi-view-dashboard' },
        { title: 'Account', icon: 'mdi-account-box' },
        { title: 'Admin', icon: 'mdi-gavel' },
      ]
    }
  }
}
</script>

<style scoped>

</style>