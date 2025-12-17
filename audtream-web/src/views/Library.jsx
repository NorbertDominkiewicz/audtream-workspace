import LibraryIcon from "../assets/icons/library.png";

function Library() {
    return(
        <div className="container bg-linear-to-br from-[#141414] to-[#0a0a0a] rounded-3xl p-8 md:p-12 mb-10 flex flex-col gap-3 mt-15">
            <div className="px-6">
              <span className="text-2xl md:text-3xl font-extrabold leading-tight text-white flex flex-row items-center gap-4">Library <img src={ LibraryIcon } alt="" /></span>
            </div>
            <div className="w-full flex justify-center items-center flex-col gap-8">
                <div className="w-2/3 flex h-10">
                    <input type="text" className="w-3/4 bg-gray-50 text-xl"/>
                    <button className="flex flex-row items-center gap-1 w-1/4 justify-center font-bold bg-purple-700 text-white cursor-pointer">
                        Szukaj 
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg>             
                    </button>
                </div>
                <div className="w-full flex justify-center">
                    <div className="w-2/3 ">
                        <span className="text-1xl md:text-2xl font-bold leading-tight text-white flex flex-row items-center gap-4">Filters</span>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Library;