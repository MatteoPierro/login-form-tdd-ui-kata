import React from "react";

interface props {
}

class Login extends React.Component<props> {

    render() {
        return <div>
            <label htmlFor={"1"}>Phone, email or username</label>
            <input id={"1"} type={"text"}/>
        </div>;
    }
}

export default Login;
