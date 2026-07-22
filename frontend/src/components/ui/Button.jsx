import { motion } from "framer-motion";

function Button({
  children,
  variant = "primary",
  onClick,
  disabled = false,
  loading = false,
  className = "",
}) {
  const variants = {
    primary: "bg-indigo-600 hover:bg-indigo-700 text-white",
    secondary: "bg-gray-200 hover:bg-gray-300 text-gray-900",
    danger: "bg-red-500 hover:bg-red-600 text-white",
    success: "bg-emerald-500 hover:bg-emerald-600 text-white",
  };

  return (
    <motion.button
      whileHover={{ scale: 1.03 }}
      whileTap={{ scale: 0.97 }}
      onClick={onClick}
      disabled={disabled || loading}
      className={`
        px-5
        py-2.5
        rounded-xl
        font-medium
        transition-all
        duration-200
        shadow-sm
        disabled:opacity-50
        disabled:cursor-not-allowed
        ${variants[variant]}
        ${className}
      `}
    >
      {loading ? "Loading..." : children}
    </motion.button>
  );
}

export default Button;