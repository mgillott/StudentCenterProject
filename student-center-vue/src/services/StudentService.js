import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {

    getAllStudents() {
        return http.get('/students');
    },

    getStudentById(studentId){
        return http.get(`/students/${studentId}`);
    },

    getStudentSchedule(studentId){
        return http.get(`/students/schedule/${studentId}`);
    },
    
}