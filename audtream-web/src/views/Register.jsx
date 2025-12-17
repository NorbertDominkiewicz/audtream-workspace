import RoleButton from "../components/register/RoleButton";

function Register(){
    return (
        <div className="container bg-linear-to-br from-[#141414] to-[#0a0a0a] rounded-3xl p-8 md:p-12 mb-10 flex flex-col gap-3 mt-25">
            <div className="px-6">
              <span className="text-2xl md:text-3xl font-extrabold leading-tight text-white">Register</span>
            </div>
            <div className="flex justify-center">
              <div className="bg-linear-to-br from-[#292828] to-[#1d1c1c] rounded-3xl p-8 md:p-12 mb-10 flex flex-col gap-6 items-center">
                <div className="flex-1 flex flex-col gap-3">
                    <div className="flex flex-row justify-evenly w-full py-8 ">
                        <RoleButton value={"Listener"}/>
                        <div className="w-1 h-full bg-purple-800"></div>
                        <RoleButton value={"Artist"}/>
                    </div>
                    <div>
                        <span className="text-gray-300 font-mono">Username</span>
                    </div>
                    <div className="border-2 rounded-lg border-purple-800 px-4 xl:py-1.5 2xl:py-2">
                        <span>👤 </span>
                        <input className="font-mono placeholder-gray-400 text-gray-300 focus:outline-hidden" type="text" placeholder="Music Enjoyer 3000"/>
                    </div>
                    <div>
                        <span className="text-gray-300 font-mono">Email</span>
                    </div>
                    <div className="border-2 rounded-lg border-purple-800 px-4 xl:py-1.5 2xl:py-2">
                        <span>📧 </span>
                        <input className="font-mono placeholder-gray-400 text-gray-300 focus:outline-hidden" type="text" placeholder="you@example.com"/>
                    </div>
                </div>
                <div className="flex-1 flex flex-col gap-3">
                    <div>
                        <span className="text-gray-300 font-mono">Password</span>
                    </div>
                    <div className="border-2 rounded-lg border-purple-800 px-4 xl:py-1.5 2xl:py-2">
                        <span>🔑 </span>
                        <input className="font-mono placeholder-gray-400 text-gray-300 focus:outline-hidden" type="password" placeholder="Minimum 9 characters"/>
                    </div>
                </div>
                <div className="flex-1 flex flex-col gap-3">
                    <div>
                        <span className="text-gray-300 font-mono">Repeat Password</span>
                    </div>
                    <div className="border-2 rounded-lg border-purple-800 px-4 xl:py-1.5 2xl:py-2">
                        <span>🔑 </span>
                        <input className="font-mono placeholder-gray-400 text-gray-300 focus:outline-hidden" type="password" placeholder="Minimum 9 characters"/>
                    </div>
                </div>
                <div className="flex flex-row pt-4 w-full justify-center">
                    <button className="w-full flex flex-row justify-center border-purple-800 bg-[#0A0A0A] border-2 rounded-2xl px-6 py-2 text-gray-300 cursor-pointer transform hover:border-purple-900 transition-all duration-300">
                        Register
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-arrow-right-short" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8"/>
                    </svg>
                    </button>
                </div>
              </div>
            </div>
          </div>
    );
}

export default Register;
 