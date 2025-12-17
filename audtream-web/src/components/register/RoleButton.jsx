import { useState, useEffect } from "react";

function RoleButton( { value } ) {
    const [isClicked, setIsClicked] = useState(false);

    return(
        <button className={
            `text-purple-700 bg-gray-400 px-3 py-2 rounded-lg transform hover:bg-neutral-200 transition-all duration-300 cursor-pointer font-bold ${isClicked ? 'bg-amber-300' : 'bg-amber-600'}`
        }
        >
        { value }
        </button>
    );
}

export default RoleButton;