import { Link } from "react-router-dom";
import Logo from "../assets/images/logo.png"
import HamburgerMenu from "../assets/icons/hamburger-menu.svg";
import Search from "../components/Search";
import { useRef, useState, useEffect } from "react";


function Navbar() {
    return( 
        <nav className="bg-[#0a0a0a] shadow-md py-4 font-mono w-full h-auto fixed top-0 z-500">
            {/* Desktop */}
            <div className="container mx-auto hidden md:grid grid-cols-3 items-center text-sm">
                {/* LEFT */}
                <div className="flex items-center gap-8">
                <Link to="/library" className="text-white hover:text-gray-300 transition">
                    Library
                </Link>
                <Search />
                </div>
                {/* CENTER */}
                <div className="flex justify-center">
                <Link to="/">
                    <img src={Logo} alt="Logo" className="h-16" />
                </Link>
                </div>
                {/* RIGHT */}
                <div className="flex justify-end items-center gap-4 2xl:gap-6">
                <label className="font-bold bg-linear-to-r from-green-500 to-red-600 bg-clip-text text-transparent"><span className="text-white">🎄 </span>Merry Christmas<span className="text-white"> ☃️</span></label>
                <Link to="/download" className="text-white hover:text-gray-300">Download</Link>
                <Link to="/artists" className="text-white hover:text-gray-300">Artists</Link>
                <Link to="/support" className="text-white hover:text-gray-300">Support</Link>
                <div className="relative group">
                    <Link to="/login" className="text-white hover:text-gray-300">Account</Link>
                    <div className="absolute bg-[#0a0a0a] hidden group-hover:flex flex-col gap-3 top-full -left-5 px-5 py-5 rounded-b-lg">
                        <Link to="/login" className="text-white hover:text-gray-300">Login</Link>
                        <div className="bg-purple-600 h-px w-full"></div>
                        <Link to="/register" className="text-white hover:text-gray-300">Resister</Link>
                    </div>
                </div>
                </div>
            </div>
            {/* Mobile */}
            <div className="container mx-auto md:hidden flex flex-row items-center text-sm justify-between px-4">
                {/* LEFT */}
                <div>
                    <Link to="/">
                    <img src={Logo} alt="Logo" className="h-16" />
                    </Link>
                </div>
                {/* RIGHT */}
                <div>
                    <button>
                        <img src={ HamburgerMenu } alt="Hamburger Menu" className="h-10"/>
                    </button>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;