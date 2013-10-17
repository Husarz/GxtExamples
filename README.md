GxtExamples
===========

Gxt Examples


- server : writing  from Servlet Input Stream to file

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletInputStream inputStream = req.getInputStream();
		Enumeration enumer = req.getHeaderNames();
		String name = req.getHeader("filename");
		
		FileOutputStream fs = new FileOutputStream("./" + name);
		
		
		try {

			byte[] tempbuffer = new byte[4096];
			int bytesRead, total = 0;
			while ((bytesRead = inputStream.read(tempbuffer)) != -1) {
				fs.write(tempbuffer, 0, bytesRead);
				total += bytesRead;
			}
			inputStream.close();
			fs.close();
			
			resp.getWriter().print(String.format("got %d bytes", total));
		} finally {
			inputStream.close();
		}
	}
