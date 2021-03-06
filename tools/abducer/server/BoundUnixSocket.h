// ----------------------------------------------------------------------------
// Copyright (C) 2010-2011 DFKI GmbH Talking Robots 
// Miroslav Janicek (miroslav.janicek@dfki.de) 
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License 
// as published by the Free Software Foundation; either version 2.1 of
// the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
// 02111-1307, USA.
// ----------------------------------------------------------------------------

#ifndef BOUNDUNIXSOCKET_H__
#define BOUNDUNIXSOCKET_H__  1

#include <string>

class BoundUnixSocket {
public:
	BoundUnixSocket(const std::string & dirprefix, const std::string & filename);
	virtual ~BoundUnixSocket();

	int getFd() { return fd; };
	std::string getPath() { return dir + "/" + file; };

private:
	int fd;
	std::string dir;
	std::string file;
};

#endif
