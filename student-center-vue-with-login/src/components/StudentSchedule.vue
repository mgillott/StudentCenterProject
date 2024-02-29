<template>
    <div v-for="schedule in schedule">
        <ScheduleCard v-bind:schedule="schedule"></ScheduleCard>
    </div>
</template>

<script>
import ScheduleCard from './cards/schedule-card.vue';
export default{
    props: ['schedule'],
    components: { ScheduleCard }
};
</script>

<style>
</style>

