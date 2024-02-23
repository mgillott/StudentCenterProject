<template>
    <div v-for="schedule in schedule">
        <h2>{{ schedule.periodName }}</h2>
        <p>{{ schedule.subjectName }}</p>
        <p>{{ schedule.teacherFirstName }}</p>
        <p>{{ schedule.teacherLastName }}</p>
    </div>
</template>

<script>
export default{
    props:['schedule'],
};
</script>

<style>
</style>

