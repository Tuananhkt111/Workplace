import axios from 'axios';
import { useHistory } from "react-router-dom";
import React, {useEffect} from "react";
const checkRequests= Wrapped => {
    function CheckRequests(props) {
        let history = useHistory();
        useEffect(()=>{
            axios.interceptors.response.use(function (response) {
                return response;
            }, function (error) {
                
                switch (error.response.status) {
                    case 401:
                        history.push('/login')
                        break
                    default :
                    history.push('/error')
                        break
                }
                // Do something with response error
                return Promise.reject(error);
            });
        })

        return (
            <Wrapped {...props} />
        )
    }
    return CheckRequests;
}

export default checkRequests