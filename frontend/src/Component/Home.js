import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {

    const [todos, setToDos] = useState([]);

    useEffect(() => {
        loadToDo();
    }, []);

    const loadToDo = async() => {
        const result = await axios.get("http://localhost:8080/api/todo");
        setToDos(result.data);
    }

    return (
        <div className="container">
            <h2 className="header">To Do List</h2>
            <ul>
                {todos.map((todo, id) => (
                    <li key={id}>{todo.title}</li>
                ))}
            </ul>
        </div>
    )
}