import { Search } from "lucide-react";

function SearchBar({ value, onChange }) {
  return (
<div className="flex items-center bg-white rounded-xl px-4 py-3 shadow">

    <Search size={20} className="text-gray-400" />

    <input
        type="text"
        value={value}
        onChange={onChange}
        placeholder="Search events, people, locations..."
        className="flex-1 ml-3 outline-none bg-transparent"
    />

</div>
  );
}

export default SearchBar;