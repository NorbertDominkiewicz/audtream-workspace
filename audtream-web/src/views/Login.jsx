function Login(){
    return (
        <div className="container bg-linear-to-br from-[#141414] to-[#0a0a0a] rounded-3xl p-8 md:p-12 mb-10 flex flex-col gap-3 mt-25">
            <div className="px-6">
              <span className="text-2xl md:text-3xl font-extrabold leading-tight text-white">Login</span>
            </div>
            <div className="flex justify-center">
              <div className="bg-linear-to-br from-[#292828] to-[#1d1c1c] rounded-3xl p-8 md:p-12 mb-10 flex flex-col gap-6 items-center">
                <div className="flex-1 flex flex-col gap-3">
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
                        <input className="font-mono placeholder-gray-400 text-gray-300 focus:outline-hidden" type="password" placeholder="Who knows..."/>
                    </div>
                </div>
                <div className="flex-1 flex flex-row gap-3 w-full">
                    <label class="flex items-center cursor-pointer relative">
                        <input type="checkbox" class="peer h-5 w-5 cursor-pointer transition-all appearance-none rounded shadow hover:shadow-md border border-slate-300 checked:bg-purple-500 checked:border-purple-500" id="check2" />
                        <span class="absolute text-white opacity-0 peer-checked:opacity-100 top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-3.5 w-3.5" viewBox="0 0 20 20" fill="currentColor" stroke="currentColor" stroke-width="1">
                                <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"></path>
                            </svg>
                        </span>
                    </label>
                    <label for="stay_logged" className="text-gray-300">Stay Logged</label>
                </div>
                <div className="flex-1 flex flex-col gap-3">
                    <div>
                        <button className="border-purple-800 bg-[#0A0A0A] border-2 rounded-2xl px-6 py-2 text-gray-300 cursor-pointer transform hover:px-7 hover:border-purple-900 transition-all duration-300">Log In</button>
                    </div>
                </div>
                <div className="flex-1 flex flex-col gap-3 border-t-2 border-t-stone-600 p-4 w-full">
                    <div className="w-2/3">
                        <span className="text-gray-300 font-bold text-wrap">Troubles during logging in ?</span>
                    </div>
                    <div className="flex flex-row pt-4 w-full justify-center">
                        <button className="border-purple-800 bg-[#0A0A0A] border-2 rounded-2xl px-6 py-2 text-gray-300 cursor-pointer transform hover:border-purple-900 transition-all duration-300">Reset Password</button>
                    </div>
                </div>
              </div>
            </div>
          </div>
    );
}

export default Login;
