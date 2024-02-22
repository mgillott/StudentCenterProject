<template>
<body>
      <nav class="navbar">
        <ul>
          <router-link v-bind:to="{name: 'home'}"><li>Home</li></router-link>
          <router-link v-bind:to="{name: 'students'}"><li>Students</li></router-link>
          <router-link v-bind:to="{name: 'teachers'}"><li>Teachers</li></router-link>
        </ul>
      </nav>

    <main>
      <h3>This is Student Center</h3>
    </main>
</body>
</template>

<script>

</script>

<style>

body {
    margin: 0px;
    margin-top: 0px;
  }

  h1{
    text-align: center;
  }

  .navbar{
    margin-top: 0px;
    text-align: center;
  }

  .navbar ul{
    list-style-type: none;
    background-color:aqua;
    padding: 1px;
    margin: 0px;
    overflow: hidden;
  }

  .navbar li{
    padding: 15px;
    display: block;
    text-align: center;
  }
  
  .navbar li:hover {
    background-color: rgb(48, 161, 165);
    color: azure;
  }

  .navbar li{
    float: left;
  }


</style>
