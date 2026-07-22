function Chip({
  children,
  active = false,
  onClick,
}) {
  return (
    <button
      onClick={onClick}
      className={`
        px-4
        py-2
        rounded-full
        text-sm
        font-medium
        whitespace-nowrap
        transition-all
        duration-200

        ${
          active
            ? "bg-indigo-600 text-white"
            : "bg-white border border-gray-200 hover:bg-gray-100"
        }
      `}
    >
      {children}
    </button>
  );
}

export default Chip;