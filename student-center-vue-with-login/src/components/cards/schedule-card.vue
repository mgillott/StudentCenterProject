<template>
    <div class="div-wrapper">
        <h2 class="period">{{ schedule.periodName }}</h2>
        <div class="schedule-details">
            <h3>Subject Name: {{ schedule.subjectName }}</h3>
            <h3>Teacher: {{ schedule.teacherLastName }}, {{ schedule.teacherFirstName }}</h3>
        </div>
    
    </div>
</template>

<script>
    export default  {
       props: [
            'schedule'
        ]
    }
</script>

<style>
    .div-wrapper  {
        display: flex;
        flex-direction: column;
        border: 1px solid;
        border-radius: 10px;
        margin: 10px;
    }

    .period {
        display: flex;
        flex-direction: row;
        justify-content: center;
        border-bottom: .5px solid;
        
    }

    .schedule-details {
        display: flex;
        flex-direction: column;
        margin-left: 20px;
    }
</style>