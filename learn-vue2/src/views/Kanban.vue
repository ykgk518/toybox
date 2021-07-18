<template>
  <v-row
      class="grey lighten-4 ma-10" justify="center"
      style="height: 1000px;"
  >
    <v-col v-for="n in 3" :key="n" cols=4>
      <v-card color="indigo lighten-4" height="800" max-height="800" outlined tile>
        <v-card
            class="mx-10 my-10"
            max-width="344"
            elevation="10"
            shaped
        >button
        </v-card>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "Kanban",
  data() {
    return {
      appTitle: 'Kanban App',
      sidebar: false,
      sidebarItems: [
        {title: 'Dashboard', path: '/dashboard', icon: 'mdi-view-dashboard'},
        {title: 'Account', path: '/account', icon: 'mdi-account-box'},
        {title: 'Admin', path: '/admin', icon: 'mdi-gavel'},
      ]
    }
  }
}
</script>

<style scoped>

</style>