import React, { useEffect, useState } from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

export default function Home() {

    let navigate = useNavigate();

    const [todos, setToDos] = useState([]);

    useEffect(() => {
        loadToDo();
    }, []);

    const loadToDo = async() => {
        const result = await axios.get("http://localhost:8080/api/todo");
        setToDos(result.data);
    }

    const [item, setItem] = useState({
        title:"",
    });

    const {title} = item;

    const onInputChange = (e) => {
        setItem({...item,[e.target.name]:e.target.value})
    }

    const onSubmit = async(e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/add", item);
        await loadToDo();
        setItem({...item,title:""});
        navigate("/")
    }

    return (
        <div className="container">
            <h2 className="header">To Do List</h2>
            <form onSubmit={(e) => onSubmit(e)}>
                <div className="add-todo">
                    <input type={"text"} placeholder="Your Task" name="title" value={title} onChange={(e) => onInputChange(e)}></input>
                    <button type="submit">Add</button>
                </div>
            </form>
            <ul className="todoitems">
                {todos.map((todo, id) => (
                    <li key={id}>{todo.title}</li>
                ))}
            </ul>
        </div>
    )
}