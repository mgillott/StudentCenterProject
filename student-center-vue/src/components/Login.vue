<template>
    <h2>Student Center Login</h2>
    <div class="login">
        <input type="text" placeholder="Enter Username" />
        <input type="password" placeholder="Enter Password" />
        <button>Login</button>
    </div>
</template>


<script>
    export default{
        name:'Login'
    }
</script>

<style>
h2{
    text-align: center;
}
.login input{
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