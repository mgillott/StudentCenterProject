import axios from 'axios';

export default {

    getAllStudents() {
        return axios.get('/students');
    },

    getStudentById(studentId){
        return axios.get(`/students/${studentId}`);
    },

    getStudentSchedule(studentId){
        return axios.get(`/students/schedule/${studentId}`);
    },
    
}