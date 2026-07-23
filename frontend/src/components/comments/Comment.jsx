function Comment({ comment }) {
  return (
    <div className="flex gap-4 py-5 border-b border-gray-200">

      <div className="w-12 h-12 rounded-full bg-indigo-600 text-white flex items-center justify-center font-bold">

        {(comment.username || "U").charAt(0).toUpperCase()}

      </div>

      <div className="flex-1">

        <div className="flex justify-between items-center">

          <h3 className="font-semibold">
            {comment.username}
          </h3>

          <span className="text-sm text-gray-400">
            {comment.time}
          </span>

        </div>

        <p className="text-gray-700 mt-2">
          {comment.text}
        </p>

      </div>

    </div>
  );
}

export default Comment;