import "./styles/global.css";
import { Routes, Route } from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import Library from "./views/Library";
import Home from "./views/Home";
import Login from "./views/Login";
import Register from "./views/Register";
import Song from "./views/Song";
import Download from "./views/Download";

function App() {
    return (
        <Routes>
            <Route element={<MainLayout />}>
                <Route path="/" element={<Home />} />
                <Route path="/library" element={<Library />} />
                <Route path="/download" element={<Download />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/track/:id" element={<Song />} />
            </Route>
        </Routes>
    );
}

export default App;