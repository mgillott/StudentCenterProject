<template>
  <h2>Student Center Login</h2>
  <form class="login" v-on:submit.prevent="login">
    <div role="alert" v-if="invalidCredentials">
      Invalid username and password!
    </div>
    <div role="alert" v-if="this.$route.query.registration">
      Thank you for registering, please sign in.
    </div>
    <input type="text" placeholder="Enter Username" v-model="user.username" />
    <input
      type="password"
      placeholder="Enter Password"
      v-model="user.password"
    />
    <button>Login</button>
    <p>
      <router-link v-bind:to="{ name: 'register' }"
        >Need an account? Sign up.</router-link
      >
    </p>
  </form>
</template>


<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
h2 {
  text-align: center;
}
.login input {
  width: 300px;
  height: 40px;
  padding-left: 20px;
  display: block;
  margin-bottom: 30px;
  margin-right: auto;
  margin-left: auto;
  border: 1px solid aqua;
}
.login button {
  width: 320px;
  height: 40px;
  border: 1px solid aqua;
  background: aqua;
  cursor: pointer;
  display: block;
  margin-bottom: 30px;
  margin-right: auto;
  margin-left: auto;
}
</style>