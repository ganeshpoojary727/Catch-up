import { Bell } from "lucide-react";

function NotificationBell() {
  return (
    <button
      className="
        relative
        p-2
        rounded-full
        hover:bg-gray-100
        transition
      "
    >
      <Bell size={22} className="text-gray-700" />

      {/* Notification Badge */}
      <span
        className="
          absolute
          -top-1
          -right-1
          w-5
          h-5
          rounded-full
          bg-red-500
          text-white
          text-xs
          flex
          items-center
          justify-center
        "
      >
        3
      </span>
    </button>
  );
}

export default NotificationBell;