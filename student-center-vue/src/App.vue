<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <h1>Student Center</h1>
  <nav class="navbar">
        <ul>
          <router-link v-bind:to="{name: 'home'}"><li>Home</li></router-link>
          <router-link v-bind:to="{name: 'students'}"><li>Students</li></router-link>
          <router-link v-bind:to="{name: 'teachers'}"><li>Teachers</li></router-link>
        </ul>
      </nav>
  <RouterView />
</template>

<style scoped>

h1{
  background-color: aqua;
  margin-top: auto;
  margin-bottom: 0px;
}

</style>
