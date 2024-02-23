<template>
    <h2>{{ student.firstName }}</h2>
    <p>
        <strong>First Name</strong>
        {{ student.firstName }}
        <strong>Middle Name</strong>
        {{ student.middleName }}
    </p>

</template>

<script>
export default {
    props:['student'],
};
</script>

<style>

</style>